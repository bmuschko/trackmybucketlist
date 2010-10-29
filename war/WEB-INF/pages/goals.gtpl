<% include '/WEB-INF/includes/header.gtpl' %>

<link rel="stylesheet" href="/css/ui-lightness/jquery-ui-1.8.5.custom.css" type="text/css" />
<style type="text/css">
   .goals ul { list-style-type: none; margin: 0; padding: 0; margin-bottom: 10px; }
   .goals li { margin: 5px; padding: 5px; width: 250px; }
</style>

<script type="text/javascript" src="/js/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery-ui-1.8.5.custom.min.js"></script>
<script type="text/javascript" src="/js/goals.js"></script>

<h2>Goals</h2>

<a href="/goals/add">Add Goal</a>
<br><br>
<div class="goals">
   <ul id="sortable">
      <% request.goals.each { goal -> %>
         <li class="ui-state-default" id="goal_${goal.key.id}">
            ${goal.name}<br>
            ${goal.description}<br>
            <a href="/goals/delete/${goal.key.id}">Delete</a> | <a href="/goals/edit/${goal.key.id}">Edit</a>
         </li>
      <% } %>
   </ul>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>