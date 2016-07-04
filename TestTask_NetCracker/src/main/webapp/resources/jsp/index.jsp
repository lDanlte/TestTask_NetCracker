<%-- 
    Document   : index
    Created on : 04.07.2016, 11:23:13
    Author     : dantonov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editor</title>
        
        <link rel="stylesheet" type="text/css" href="<c:url value="/lib/bootstrap/css/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />" />
        
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <table class="table" data-selected="">

                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="table" items="${tableEntities}">
                            <tr id='item_id_${table.id}' onclick="selectRow(this);">
                                <td>${table.id}</td>
                                <td>${table.name}</td>
                                <td>${table.desc}</td>
                            </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>
            </div>
            
            <div class="row">
                <div class="btn-toolbar" role="toolbar">

                    <button type="button" class="btn btn-info btn-sm" onclick="add();">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add
                    </button>

                    <button type="button" class="btn btn-primary btn-sm" onclick="edit();">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit
                    </button>

                    <button type="button" class="btn btn-danger btn-sm" onclick="deleteItem();">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Delete
                    </button>

                </div>
            </div>
        </div>
        
        
        <div id="modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Add/Edit</h4>
                    </div>
                    <div class="modal-body">
                        
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="inputName" class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputDesc" class="col-sm-2 control-label">Description</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" id="inputDesc" ></textarea>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="save();">Save</button>
                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="modal fade" id="modalInfo">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                  <button type="button" class="btn jump-button" data-dismiss="modal">Закрыть</button>
                </div>
              </div>
            </div>
        </div>
        
        <div id="localUrl" data-url="<c:url value="/" />"></div>
        
        
        
        <script type="text/javascript" src="<c:url value="/lib/jquery/jquery-2.2.4.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/lib/bootstrap/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/index.js" />"></script>
        
    </body>
</html>
