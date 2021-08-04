/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pokedex.ec.bo;

import com.pokedex.ec.entity.Ability;
import com.pokedex.ec.entity.Types;
import com.pokedex.ec.dao.Methods;
import com.pokedex.ec.dao.TypeAbilityDAO;
import com.pokedex.ec.db.Conexion;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author
 */
public class TypeAbilityBO {

    private String message = "";
    private TypeAbilityDAO tadao = new TypeAbilityDAO();
    private Methods mdao = new Methods();

    public void cmbType(JComboBox cboxUser) {
        Connection conn = Conexion.getConnection();

        try {

            tadao.cmbType(conn, cboxUser);

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

    }

    public void listAbilities(JList list) {
        Connection conn = Conexion.getConnection();

        try {

            tadao.listAbilities(conn, list);

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

    }

    public void listAbilitiesNeg(JList list, int id) {
        Connection conn = Conexion.getConnection();

        try {

            tadao.listAbilitiesNeg(conn, list, id);

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

    }

    public void listTypes(JList list) {
        Connection conn = Conexion.getConnection();

        try {

            tadao.listTypes(conn, list);

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

    }

    public String addAbility(String object) {
        Connection conn = Conexion.getConnection();

        try {

            message = tadao.addAbility(conn, object);

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

        return message;
    }

    public String addAbilityP(Ability pok) {
        Connection conn = Conexion.getConnection();

        try {
            message = tadao.addAbilityP(conn, pok);

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

    public void deleteAbilityFull(Ability pok) {
        Connection conn = Conexion.getConnection();

        try {
            tadao.deleteAbilityFull(conn, pok);

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

    public void deleteAbilityP(Ability pok) {
        Connection conn = Conexion.getConnection();

        try {
            tadao.deleteAbilityP(conn, pok);

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

    public String addType(String object) {
        Connection conn = Conexion.getConnection();

        try {

            message = tadao.addTypes(conn, object);

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

        return message;
    }

    public void deleteTypeFull(Types pok) {
        Connection conn = Conexion.getConnection();

        try {
            tadao.deleteTypefull(conn, pok);

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

}
