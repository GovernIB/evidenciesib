





<script type="text/javascript">
  // Comentari: Construïm un objecte JS a partir del map JSTL
  var classesDisponibles = {
    <c:forEach var="entry" items="${classesDisponibles}" varStatus="status">
      "${entry.key}": "${entry.value}"<c:if test="${!status.last}">,</c:if>
    </c:forEach>
  };
  var valorActual = "${pluginClasseActual}";

  window.addEventListener('DOMContentLoaded', function() {
    var td = document.getElementById('plugin_classe_columnvalueid');
    var input = document.getElementById('plugin.classe');
    if (td && input) {
      // Comentari: Creem el select
      var select = document.createElement('select');
      select.id = input.id;
      select.name = input.name;
      select.className = input.className;

      // Comentari: Afegim les opcions
      for (var key in classesDisponibles) {
        if (classesDisponibles.hasOwnProperty(key)) {
          var option = document.createElement('option');
          option.value = key;
          option.text = classesDisponibles[key];
          if (key === valorActual) {
            option.selected = true;
          }
          select.appendChild(option);
        }
      }

      // Comentari: Substituïm l'input pel select
      td.replaceChild(select, input);
    }
  });
</script>
