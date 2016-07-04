var IS_ADD = false;
var LOCAL_URL = $("#localUrl").data("url");

function selectRow(elem) {
    
    elem = $(elem);
    
    elem.parent("tbody").find("tr").each(function (index, item) {
        $(item).removeClass("active");
    });
    
    elem.addClass("active");
    var id = $(elem.find("td")[0]).html();
    
    var table = $("table");
    table.data("selected", id);
    
}


function add() {
    
    IS_ADD = true;
    showModal();
}

function edit() {
    
    IS_ADD = false;
    var table = $("table");
    
    var id = table.data("selected");
    
    var item = table.find("#item_id_" + id).find("td");
    
    if (id === "") {
        showMessage("Warning", "You need to select an item.");
        return;
    }
    
    var modal = $("#modal");
    modal.find("#inputName").val($(item[1]).html());
    modal.find("#inputDesc").val($(item[2]).html());
    showModal();
}

function deleteItem() {
    
    var id = $("table").data("selected");
    
    if (id === "") {
        showMessage("Warning", "You need to select an item.");
        return;
    }
    
    $.ajax({
        url: LOCAL_URL + "table/" + id,
        method: "DELETE",
        success: function () {
            $("#item_id_" + id).remove();
            showMessage("Success", "The item has been deleted.");
        },
        error: function (XMLHttp, textStatus, errorThrown) {
            var response = XMLHttp.responseJSON;
            if (response === undefined) {
                 showMessage("Warning", "Something bad is happend while deleting data.");
            } else {
                showMessage("Warning", response.msg);
            }
        }
        
    });
}

function clearModal() {
    var modal = $("#modal");
    modal.find("#inputName").val("");
    modal.find("#inputDesc").val("");
}

function showModal() {
    $("#modal").modal();
}


function showMessage(title, message) {
    var modal = $("#modalInfo");
    
    modal.find(".modal-body").html(message);
    modal.find(".modal-title").html(title);
    
    modal.modal();
}

function save() {
    
    var modal = $("#modal");
    var name = modal.find("#inputName").val();
    var desc = modal.find("#inputDesc").val();
    
    var data = {
        name: name,
        desc: desc
    };
    if (IS_ADD) {
        
        $.ajax({
            url: LOCAL_URL + "table",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(data) {
                addRow(data);
                clearModal();
                $('#modal').modal('hide');
            },
            error: function (XMLHttp, textStatus, errorThrown) {
                var response = XMLHttp.responseJSON;
                if (response === undefined) {
                     showMessage("Warning", "Something bad is happend while adding data.");
                } else {
                    showMessage("Warning", response.msg);
                }
            }
        });
        
    } else {
        
        $.ajax({
            url: LOCAL_URL + "table/" + $("table").data("selected"),
            method: "PUT",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(data) {
                var elems = $("#item_id_" + data.id).find("td");
                $(elems[1]).html(data.name);
                $(elems[2]).html(data.desc);
                clearModal();
                $('#modal').modal('hide');
            },
            error: function (XMLHttp, textStatus, errorThrown) {
                var response = XMLHttp.responseJSON;
                if (response === undefined) {
                     showMessage("Warning", "Something bad is happend while editing data.");
                } else {
                    showMessage("Warning", response.msg);
                }
            }
        });
        
    }
}

function addRow(data) {
    
    $("table").find("tbody").append("<tr id='item_id_" + data.id + "' onclick='selectRow(this);'>" + 
                                       "<td>" + data.id + "</td>" +
                                       "<td>" + data.name + "</td>" +
                                       "<td>" + data.desc + "</td>" +
                                    "</tr>");
}