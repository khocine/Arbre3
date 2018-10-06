
//$(function () {
//    'use strict';
//
//    var productArray;
//
//    $.getJSON( "Display", { format: "json" })
//        .done(function( data ) {
//            
//            productArray = data;
//
//            $('#autocomplete').autocomplete({
//                lookup: productArray,
//                appendTo: "#search-container",
//                onSelect: function (suggestion) {
//        			window.location = "Display?savon=" + suggestion.value;
//    			}
//            });
//        });
//});

$(function () {
    'use strict';

    var productArray = [];

    $.getJSON( "Display", { format: "json" })
        .done(function( data ) {

            for (var key in data) {
                var row = { "value":data[key], "key": key }
                productArray.push(row)
            }

            $('#autocomplete').autocomplete({
            	lookup: productArray,
                appendTo: "#search-container",
                onSelect: function (suggestion) {
        			window.location = "Display?savon=" + suggestion.key;
    			}
            });
        });
});