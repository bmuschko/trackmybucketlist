<% include '/WEB-INF/includes/header.gtpl' %>

<%
  def goal = request.getAttribute("goal")
  boolean existingKey = goal?.key
  String action = !existingKey ? 'Add' : 'Update'
%>

<h2>${action} Goal</h2>

<form action="/user/goals/${!existingKey ? 'insert' : 'update'}" method="POST">
   <table border="0">
      <tbody>
         <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${goal?.name ? goal.name : ''}"></td>
         </tr>
         <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${goal?.description ? goal.description : ''}"></td>
         </tr>
      </tbody>
      <% if(existingKey) { %>
         <input type="hidden" name="id" value="${goal.key.id}">
      <% } %>
   </table>
   <br>
   <input type="submit" value="${action}">
   <input type="button" value="Cancel" onclick="javascript:document.location.href = '/user/goals';">
</form>

<% include '/WEB-INF/includes/footer.gtpl' %>