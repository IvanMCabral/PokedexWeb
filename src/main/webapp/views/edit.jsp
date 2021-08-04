<%-- 
    Document   : edit
    
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.pokedex.ec.entity.Pokemon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.pokedex.ec.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.pokedex.ec.entity.Types"%>
<%@page import="com.pokedex.ec.bo.PokemonBO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1 class="col-auto text-light bg-dark p-5 text-center"> Edit Pokemon </h1>

            <%
                
                PokemonBO pbo = new PokemonBO();
                
                int id = Integer.parseInt((String)request.getAttribute("idpok"));
                Pokemon poke = pbo.loadPokemon(id);
                

            %>




            <form action="Controller">
                <div class="form-group  p-5 text-center col-auto  " >

                    <input type="hidden" name="txtid" value="<%= id%>" class="form-control form-control">
                    NAME:<br>
                    <input type="text" name="name" value="<%= poke.getName()%>" class="form-control form-control"><br>
                    TYPE:<br>
                    <select name="type" class="form-control form-control" value="" >
                        <option><%= poke.getType()%></option>  
                        <%

                            List<Types> listTypes = pbo.loadTypes();
                            if (listTypes != null) {

                                for (Types type : listTypes) {

                        %>

                        <option><%=type.getName()%></option>                        
                        <% }
                            }%>

                    </select><br>

                    
                    TYPE2:<br>               
                    <select name="type2" class="form-control form-control text-center" >
                        <option><%= poke.getType2()%></option>  
                        <%
                                if (listTypes != null) {
                                    for (Types type : listTypes) {%>
                        <option  value="<%=type.getName()%>"><%=type.getName()%></option>                        
                        <% }
                            }%>

                    </select><br>
                    LEVEL:<br>
                    <input type="text" name="level" value="<%= poke.getLevel()%>" class="form-control form-control"><br>
                    USER:<br>
                    <select name="user" class="form-control form-control">
                        <option><%= poke.getUser()%></option>  
                        <%

                            List<User> listUser = pbo.loadUser();
                                if (listUser != null) {
                                    for (User user : listUser) {%>
                        <option  value="<%=user.getName()%>"><%=user.getName()%></option>                        
                        <% }
                            }%>

                    </select><br>

                    <input type="submit" name="action" value="Modify Pokemon" class="form-control form-control btn btn-primary"><br>
                </div>
            </form>

        </div>
    </body>
    
    
</html>
