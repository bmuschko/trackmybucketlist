$(document).ready(function() {
   $("#sortable").sortable({
      revert: true
   });

   $("ul, li").disableSelection();
});