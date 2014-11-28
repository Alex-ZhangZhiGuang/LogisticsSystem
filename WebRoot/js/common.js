// JavaScript Document
$(function(){
	$("input[type!='submit'][type!='reset'][type!='button']").focus(function(){
		$(this).addClass("onfoucs");
	}).blur(function(){
		$(this).removeClass("onfoucs");
	});
	$("textarea").focus(function(){
		$(this).addClass("onfoucs");
	}).blur(function(){
		$(this).removeClass("onfoucs");
	});
});