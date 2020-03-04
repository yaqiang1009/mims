/**
 * 设置菜单样式
 * @param t
 */
function menuCss(t) {
	if ($(t).next().length > 0) {
		$(t).parent().siblings().removeClass("active");
		$(t).parent().siblings().children("a").children("span").css("color", "");
		$(t).parent().addClass("active");
		$(t).children("span").first().css("color", "#eee");
	} else {
		$(t).parent().parent().parent().siblings().removeClass("active");
		var clazz = $(t).parent().parent().parent().attr("class");
		if (clazz != 'active') {
			$(t).parent().parent().parent().addClass("active");
		}
		$(t).parent().parent().parent().parent().children("li").children("ul").children("li").removeClass("lia");
		$(t).parent().addClass("lia");
		$(t).parent().parent().parent().siblings().children("a").children("span").css("color", ""); 
		$(t).parent().parent().parent().children("a").children("span").first().css("color", "#eee"); 
		
	}
}
