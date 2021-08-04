/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pokedex.ec.bo;

import com.pokedex.ec.entity.Pokemon;
import com.pokedex.ec.entity.Types;
import com.pokedex.ec.entity.User;
import com.pokemon.ec.dao.Methods;
import com.pokemon.ec.dao.PokemonDAO;
import com.pokemon.ec.db.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

/**
 *
 * @author
 */
public class PokemonBO {

    private String message = "";
    private Methods mdao = new Methods();
    private PokemonDAO pdao = new PokemonDAO();

    public String addPokemon(Pokemon pok) {
        Connection conn = Conexion.getConnection();

        try {//Go to DAO
            message = pdao.addPokemon(conn, pok);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    //finally conection
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return message;
    }

    public String modifyPokemon(Pokemon pok) {

        Connection conn = Conexion.getConnection();

        try {
            message = pdao.modifyPokemon(conn, pok);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return message;
    }

    public String deletePokemon(int id) {
        Connection conn = Conexion.getConnection();

        try {
            pdao.deletePokemon(conn, id);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return message;

    }

    public ArrayList<Pokemon> loadPokemon() {
        Connection conn = Conexion.getConnection();

        ArrayList<Pokemon> Pokemonlist = new ArrayList<>();

        try {

            Pokemonlist = pdao.getPokemon(conn);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

        return Pokemonlist;
    }
    
    
    public ArrayList<Types> loadTypes() {
        Connection conn = Conexion.getConnection();

        ArrayList<Types> Typeslist = new ArrayList<>();

        try {

            Typeslist = pdao.getTypes(conn);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

        return Typeslist;
    }
    
     public ArrayList<User> loadUser() {
        Connection conn = Conexion.getConnection();

        ArrayList<User> Userlist = new ArrayList<>();

        try {

            Userlist = pdao.getUser(conn);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

        return Userlist;
    }
     
     
     

    public void tablePokemons(JTable table) {
        Connection conn = Conexion.getConnection();

        String list = pdao.tablePokemons();

        try {

            mdao.listPokemon(conn, table, list);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    
    public void tablePokemonByUser(JTable table, String string) {
        Connection conn = Conexion.getConnection();

        String list = pdao.listPokemon(string);
        try {

            mdao.listPokemon(conn, table, list);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public void tablePokemonEvo(JTable table, int id) {
        Connection conn = Conexion.getConnection();

        try {

            pdao.tablePokemonEvo(conn, table, id);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public void listAbilities(JList list, int id) {
        Connection conn = Conexion.getConnection();

        String name = pdao.listAbilities(list, id);

        try {

            mdao.list(conn, list, name);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public void listPoke(JList list) {
        Connection conn = Conexion.getConnection();

        String name = pdao.listPoke(list);

        try {

            mdao.list(conn, list, name);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public void cmbPoke(JComboBox cboxUser) {

        Connection conn = Conexion.getConnection();

        try {

            pdao.cmbPoke(conn, cboxUser);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public void cmbEvo(JComboBox cboxUser) {
        Connection conn = Conexion.getConnection();

        try {

            pdao.cmbLastEvo(conn, cboxUser);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }

    }

    public int serchaId(String Poke) {
        int poke = 0;
        Connection conn = Conexion.getConnection();

        try {
            poke = mdao.searchbyname(conn, Poke);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return poke;
    }

    public int searchlvlmin(int id) {
        Connection conn = Conexion.getConnection();
        int min = 0;
        try {

            min = pdao.searchlvlmin(conn, id);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally try
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return min;
    }

    public int searchlvlmax(int id) {
        Connection conn = Conexion.getConnection();
        int min = 0;
        try {

            min = pdao.searchlvlmax(conn, id);

        } catch (Exception e) {

            message = message + " " + e.getMessage();
        }//finally
        finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (Exception e) {
                message = message + " " + e.getMessage();
            }
        }
        return min;
    }

}
