<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="../wlxt/css/demo.css" />
	<link rel="stylesheet" href="../wlxt/css/pagination.css" />
	<script type="text/javascript" src="../wlxt/js/jquery.min.js"></script>
	<script type="text/javascript" src="../wlxt/js/jquery.pagination.js"></script>
	<script type="text/javascript" src="../wlxt/js/members.js"></script>
        
        <script type="text/javascript">
            
            // This file demonstrates the different options of the pagination plugin
            // It also demonstrates how to use a JavaScript data structure to 
            // generate the paginated content and how to display more than one 
            // item per page with items_per_page.
                    
            /**
             * Callback function that displays the content.
             *
             * Gets called every time the user clicks on a pagination link.
             *
             * @param {int}page_index New Page index
             * @param {jQuery} jq the container with the pagination links as a jQuery object
             */
			function pageselectCallback(page_index, jq){
                // Get number of elements per pagionation page from form
                var items_per_page = $('#items_per_page').val();
                var max_elem = Math.min((page_index+1) * items_per_page, members.length);
                var newcontent = '';
                
                // Iterate through a selection of the content and build an HTML string
                for(var i=page_index*items_per_page;i<max_elem;i++)
                {
                    newcontent += '<dt>' + members[i][0] + '</dt>';
                    newcontent += '<dd class="state">' + members[i][2] + '</dd>';
                    newcontent += '<dd class="party">' + members[i][3] + '</dd>';
                }
                
                // Replace old content with new content
                $('#Searchresult').html(newcontent);
                
                // Prevent click event propagation
                return false;
            }
            
            // The form contains fields for many pagiantion optiosn so you can 
            // quickly see the resuluts of the different options.
            // This function creates an option object for the pagination function.
            // This will be be unnecessary in your application where you just set
            // the options once.
            function getOptionsFromForm(){
                var opt = {callback: pageselectCallback};
                // Collect options from the text fields - the fields are named like their option counterparts
                $("input:text").each(function(){
                    opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;
                });
                // Avoid html injections in this demo
                var htmlspecialchars ={ "&":"&amp;", "<":"&lt;", ">":"&gt;", '"':"&quot;"}
                $.each(htmlspecialchars, function(k,v){
                    opt.prev_text = opt.prev_text.replace(k,v);
                    opt.next_text = opt.next_text.replace(k,v);
                })
                return opt;
            }
			
            // When document has loaded, initialize pagination and form 
            $(document).ready(function(){
				// Create pagination element with options from form
                var optInit = getOptionsFromForm();
                $("#Pagination").pagination(members.length, optInit);
                
				// Event Handler for for button
				$("#setoptions").click(function(){
                    var opt = getOptionsFromForm();
                    // Re-create pagination content with new parameters
                    $("#Pagination").pagination(members.length, opt);
                }); 

            });
            
        </script>
  </head>
  
  <body>
    	<h1>jQuery Pagination Plugin Demo</h1>
        <div id="Pagination">
        </div>
		<br style="clear:both;" />
        <h3>List of former members of the United States House of Representatives (A)</h3>
		<dl id="Searchresult">
			<dt>Search Results will be inserted here ...</dt>
		</dl>
        <h3>Config form for pagination parameters</h3>
        <!-- This form is just to demonstrate the whole range of options and display styles. -->
		<form name="paginationoptions">
			<p><label for="items_per_page">Number of items per page</label><input type="text" value="5" name="items_per_page" id="items_per_page" class="numeric"/></p>
			<p><label for="num_display_entries">Number of pagination links shown</label><input type="text" value="10" name="num_display_entries" id="num_display_entries" class="numeric"/></p>
			<p><label for="num">Number of start and end points</label><input type="text" value="2" name="num_edge_entries" id="num_edge_entries" class="numeric"/></p>
			<p><label for="prev_text">"Previous" label</label><input type="text" value="Prev" name="prev_text" id="prev_text"/></p>
			<p><label for="next_text">"Next" label</label><input type="text" value="Next" name="next_text" id="next_text"/></p>
			<input type="button" id="setoptions" value="Set options" />
		</form>
    </body>
</html>