// Enhance the site search form
// @author Nathan White

// global variable defining the text we want in the box
search_box_text = "People & Pages";

$(document).ready(function()
{
	$("div#combinedSearch span.xtr").each( function()
	{
		$(this).css({
		position:"absolute",
		left:"-9999px",
		width:"20px",
		display:"block"});
	});
	
	$("input#combinedSearchInput").each( function()
	{
		if (conditionally_populate_text(this) == false)
		{
			if (get_current_value(this) == search_box_text)
			{
				add_labelText_class(this);
			}
		}
	});

	$("input#combinedSearchInput").focus( function()
	{
		conditionally_clear_text(this);
	});
	
	$("input#combinedSearchInput").blur( function()
	{
		conditionally_populate_text(this);
	});
	
	$("input#combinedSearchSubmit").click( function()
	{
		conditionally_clear_text($("input#combinedSearchInput"));
	});
});

function conditionally_clear_text(element)
{
	if (get_current_value(element) == search_box_text)
	{
		remove_labelText_class(element);
		set_element_value(element, "");
		return true;
	}
	return false;
}

function conditionally_populate_text(element)
{
	if (get_current_value(element) == "")
	{
		add_labelText_class(element);
		set_element_value(element, search_box_text);
		return true;
	}
	return false;
}

function add_labelText_class(element)
{
	$(element).addClass("labelText");
}

function remove_labelText_class(element)
{
	$(element).removeClass("labelText");
}

function set_element_value(element, value)
{
	$(element).attr("value", value);
}

function get_current_value(element)
{
	return $(element).attr("value") || "";
}