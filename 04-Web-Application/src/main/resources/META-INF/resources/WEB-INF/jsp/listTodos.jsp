<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

        <title>Manage Your Todos</title>
    </head>
    <body>

       <div class="container">
            <h1> Your Todos </h1>
            <Table class="table">
                <thead>
                    <tr>
                        <th> Description </th>
                        <th> Target Date </th>
                        <th> Is Done </th>
                        <th> </th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ todos }" var="todo" >
                        <tr>
                            <td> ${ todo.description } </td>
                            <td> ${ todo.targetDate } </td>
                            <td> ${ todo.done } </td>
                            <td>  </td>
                            <td>  </td>
                        </tr>
                    </c:forEach >
                </tbody>
            </Table>
       </div>

    </body>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

</html>