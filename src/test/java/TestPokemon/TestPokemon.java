package TestPokemon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pokedex.ec.bo.PokemonBO;
import com.pokedex.ec.db.Conexion;
import com.pokedex.ec.entity.Pokemon;
import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author
 */
public class TestPokemon {

    PokemonBO pbo = new PokemonBO();

    @Test
    public void TestConnection() {
        Connection conn = Conexion.getConnection();
        System.out.println(conn);
        assertNotNull(conn);

    }

    

    @Test
    public void TestInsertPokemon() {

        Pokemon pokemon1 = new Pokemon("Totodile","fire","fire",15,0,"Blue");        
        String agregado = pbo.addPokemon(pokemon1);
        String Esperado = "New Pokemon Inserted!!";
        String Esperado2 = "There is already a pokemon with that name";
        
        assertNotNull(agregado);
                 
    }
    
    @Test
    public void TestInsertPokemonNull(){
        
        Pokemon pokemonNull = new Pokemon(null,"fire","fire",15,0,"Blue");        
        String agregado = pbo.addPokemon(pokemonNull);
        String EsperadoError = "Error Save";
        
        assertEquals(EsperadoError, agregado);
    }
    
    @Test
    public void TestInsertPokemonEqual() {

        Pokemon pokemon = new Pokemon("Totodile","fire","fire",15,0,"Blue");        
        String agregado = pbo.addPokemon(pokemon);       
        String Esperado = "There is already a pokemon with that name";
        
        assertEquals(Esperado, agregado);
                 
    }
    
    @Test
    public void TestModifyPokemon(){
        String PokemonName = "Gastly";
        Pokemon pokemon = new Pokemon(PokemonName,"water","psyquic",5,1,"Red");
        pokemon.setIdpokemon(88);
    
        pbo.modifyPokemon(pokemon);
        
        int idPokeModify = pbo.serchaId(PokemonName);
        Pokemon PokeModify = pbo.loadPokemon(idPokeModify);
    
        
        assertEquals(PokeModify.getName(), PokemonName);
    
    }
    
    
    @Test
    public void TestModifyPokemonSameName(){
        String PokemonName = "Gastly";
        Pokemon pokemon = new Pokemon(PokemonName,"water","psyquic",5,1,"Red");
        pokemon.setIdpokemon(85);
    
        String result = pbo.modifyPokemon(pokemon);
        
        if(result == "There is already a pokemon with that name"){
        result = null;   
        }
      
        assertNull(result);
    
    }
    
    
   
    
    @Test
    public void TestFindIdPokemonByNameExist() {

        String resultado = null;
        String Pokemon = "Charmeleon";
        int idPokemon = pbo.serchaId(Pokemon);
        if(idPokemon != 0 ){
        resultado = String.valueOf(idPokemon);
        }
        

        assertNotNull(resultado);

    }
    
    
    @Test
    public void TestFindIdPokemonByNameNotExist() {
        String resultado = null;
        String Pokemon = "Cindaquil";
        int idPokemon = pbo.serchaId(Pokemon);
        if(idPokemon != 0 ){
        resultado = String.valueOf(idPokemon);
        }

        assertNull(resultado);

    }
    
     @Test
    public void TestFindIdPokemonByNameEqual() {

        String Pokemon = "Charmander";
        int idPokemon = pbo.serchaId(Pokemon);
        int Esperado = 82;

        assertEquals(Esperado, idPokemon);

    }
    
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
