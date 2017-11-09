<%-- 
    Document   : VendingMachine
    Created on : Oct 7, 2017, 5:26:51 PM
    Author     : ritheenhep
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/vending.css" rel="stylesheet">  
    </head>
    <body>
        <div class="container" Style="text-align: center">
            <h1 style="Text-align: center">Vending Machine</h1>
            <ul class="list-group" id="errorMessages"></ul>
            <hr/>

            <div class="row">
                <div class="col-md-9" id="prod-diplay">
                    <form action="getItem"  method="POST" >
                        <c:forEach var="currentItem" items="${itemList}">
                            
                            <button name ="selectedItem" value="${currentItem.itemNumber}"   type="submit"  class="btn btn-default" id="products-btn" >

                                <p> <c:out value="${currentItem.itemNumber}"/> </p>
                                <p> <c:out value="${currentItem.itemName}"/> </p>
                                <p> $<c:out value="${currentItem.itemPrice}"/> </p>
                                <p> <c:out value="${currentItem.inventory}"/> </p>
                            </button>

                        </c:forEach>

                    </form>
                </div>


                <div class="col-md-3" id="bank">
                    <div class="row">
                        <h3 Style="text-align: center">Total $ In</h3>

                        <div class="col-md-12">
                            <div class="form-group">
                                <input name="checkMoney" value="$${displayMoney}" class="form-control" style="text-align: center" id="display-money" placeholder="Enter Money" readonly/>
                            </div>

                            <div class="col-md-6">
                                <form action="addMoney" method="POST">
                                    <button type="submit" 
                                            name="money"  
                                            value="one" 
                                            id="addOne" 
                                            style="text-align: center" 
                                            class="btn btn-default ">
                                        Add Dollar
                                    </button>
                                </form>
                            </div>


                            <div class="col-md-6">
                                <form action="addMoney" method="POST">
                                <div class="form-group">
                                    <button type="submit"
                                            name="money"  
                                            value="qrtr" 
                                            id="addQRTR" 
                                            style="text-align: center" 
                                            class="btn btn-default">
                                        Add Quarter
                                    </button>
                                </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <form action="addMoney" method="POST">
                                    <div class="form-group">
                                        <button type="submit"
                                                name="money" 
                                                value="dime" 
                                                id="addDime" 
                                                style="text-align: center"
                                                class="btn btn-default">
                                            Add Dime
                                        </button>
                                    </div>
                                </form>
                            </div>

                            <div class="col-md-6">
                                <form action="addMoney" method="POST">
                                    <div class="form-group">
                                        <button type="submit"
                                                name="money"
                                                value="nickel" 
                                                id="addNickel" 
                                                style="text-align: center" 
                                                class="btn btn-default ">
                                            Add Nickels
                                        </button>
                                    </div>
                                </form>
                            </div>
                           
                                <div class="form-group">
                                    <hr/>
                                    <h2 Style="text-align: center">MESSAGE</h2>
                                    <input class="form-control" style="text-align: center" value="${message}" id="displaymessage" placeholder="Message">
                                </div>

                                <div class="form-group">
                                    <label for="displayItem" style="text-align: center" class="col-sm-2 control-label">
                                        Item:
                                    </label>
                                    <div class="col-md-8">
                                        <input name="item" value="${itemId}" class="form-control" style="text-align: center"  id="vending" readonly/>
                                    </div>
                                </div>  
                                     <form action="buyItem" method="POST">
                                <button type="submit"  name="purchase"  id="purchase" style="text-align: center" class="btn btn-default">Make Purchase</button>
                                <hr/>
                                     </form>
                                  <form action="returnchange" method="POST">  
                                <h1 Style="text-align: center">Change</h1>
                                <div class="form-group">

                                    <input class="form-control" style="text-align: center" id="changes" value="${giveChange}" placeholder="take your change" readonly/>

                                </div>
                                <button type="submit"  name="change" id="returnChange" style="text-align: center" class="btn btn-default">Change Return</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

