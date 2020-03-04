var BookPopup = {
    setup: function() {
        // add hidden 'div' to end of page to display popup:
        var popupDiv = $('<div id="bookInfo"></div>');
        popupDiv.hide().appendTo($('body'));
        $(document).on('click', '.book', function(data) {return(BookPopup.getBookInfo(this.form.id.value))});
    }
    ,getBookInfo: function(bookid) {
        $.ajax({type: 'GET',
            dataType: "json",
            url: "books/" + bookid + "/buddies",
            timeout: 5000,
            success: function (data) {return(BookPopup.showBookInfo(data, bookid))},
            error: function(xhrObj, textStatus, exception) { alert('Error!'); }
            // 'success' and 'error' functions will be passed 3 args
        });
        return(false);
    }
    ,showBookInfo: function(data, bookid) {
        $('#bookInfo').empty();


        var selectedDiv = $('<div class="openBook"></div>');
        selectedDiv.appendTo($("#bookInfo"));
        selectedDiv.text("---Selected Book Buddies---")
        for (var i = 0; i < data._embedded.BuddyInfo.length;i++ )
        {
            var buddyDiv =  $('<div class="openBook"></div>');
            buddyDiv.appendTo($("#bookInfo"));
            buddyDiv.text("Name: " + data._embedded.BuddyInfo[i].name)
        }
        var addBuddyForm = $('<form class="openBook" method="post">' +
            '    <p>Name: </p><input type="text" id="name" name="name" />' +
            '    <p>Number: </p><input type="text" id="number" name="number" />' +
            '    <p>Email: </p><input type="text" id="email" name="email" />' +
            '    <p>Address: </p><input type="text" id="address" name="address" />' +
            '<button id="addBud" type="submit">Add</button>\n' +
            '</form>')
        addBuddyForm.appendTo($("#bookInfo"));
        addBuddyForm.show();
        $('#addBud').click(function() {
            return(BookPopup.postBuddyInfo(bookid, addBuddyForm[0]))});

        // center a floater 1/2 as wide and 1/4 as tall as screen
        var oneFourth = Math.ceil($(window).width() / 4);
        $('#bookInfo').
        css({'left': oneFourth,  'width': 2*oneFourth, 'top': 250}).
        show();

        return(false);  // prevent default link action
    }
    ,postBuddyInfo: function(bookid, _this) {
        var data = {
                name: _this.name.value,
                number: _this.number.value,
                email: _this.email.value,
                address: _this.address.value
        }
        $.ajax({type: 'POST',
            url: "newBud?bookid=" + bookid,
            data: data,
            success: function(data) {return(BookPopup.getBookInfo(bookid))},
            error: function(xhrObj, textStatus, exception) { alert('Error! '+textStatus); }
            // 'success' and 'error' functions will be passed 3 args
        });
        return(false);
    }
};

$(BookPopup.setup);
