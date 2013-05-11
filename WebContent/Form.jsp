<%@ page import="fr.irit.wanda.entities.*"%>
<%@ page import="fr.irit.wanda.servlet.ClientConfiguration"%>
<%@ page import="fr.irit.wanda.dao.*"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.io.*"%>


<%
	String rawId = (String)request.getParameter("id");
	String fatherEntityName = rawId.split("_")[2];
	String entityName = rawId.split("_")[1];
	String fatherId = rawId.split("_")[0]; 
	System.err.println("Done");
%>

<% if (entityName.equals("site")){ %>
<div id="createForm" class="">
	<h2>Create a site</h2>
	<div style="margin-bottom: 5px" class="description">
		<p>
			This section allows you to create a site.
		</p>
	</div>
	<div class="space"></div>
	<form class="form" method="post" action="Create" id="add_site" name="site">
		<input type="hidden" name="entity" value="site"> 
		<label for="name"><span>Name</span></label> 
		<input type="text" name="name" placeholder="Name" autofocus="" required="" /> 
		<p class="validate">
			<input class="validate_button" name="validate" type="submit" size="40" value="Validate" />
		</p>
	</form>
</div>
<% }else if (entityName.equals("corpus")){ %>
<div id="createForm" class="">
	<h2>Create a corpus</h2>
	<div style="margin-bottom: 5px" class="description">
		<p>
			This section allows you to create a corpus.
		</p>
	</div>
	<form  class="form" method="post" action="Create" id="add_corpus" name="corpus"><br>
		<input type="hidden"  name="entity"  value="corpus">
		<input type="hidden"  name="fatherId"  value="<%=fatherId%>">
		<input type="hidden"  name="fatherEntityName"  value="<%=fatherEntityName%>">
		<label for="name"><span>Name</span></label>
		<input name="name" type="text" size="40" placeholder="Name" autofocus="" required=""/>
		<p class="validate">
			<input class="validate_button" name="validate" type="submit" size="40" value="Validate"/>
		</p>
	</form>
</div>
<%}%>
