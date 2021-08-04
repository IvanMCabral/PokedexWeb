/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pokemon.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class Methods {

    private String message = "";

    public void listPokemon(Connection con, JTable table, String string) {
        DefaultTableModel model;
        String[] columnas = {"ID", "NAME", "TYPE1", "TYPE2", "LEVEL", "EVOLUTION", "USER"};
        model = new DefaultTableModel(null, columnas);

        String sql = string;

        String[] filas = new String[7];

        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {

                    filas[i] = rs.getString(i + 1);

                }
                String n = filas[5];
                if (n.equals("1")) {
                    filas[5] = "SI";
                } else {
                    filas[5] = "NO";
                }
                model.addRow(filas);
            }
            table.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Table List");
        }
    }

    public int searchbyname(Connection con, String pokeName) {
        int idpokemon = 0;
        PreparedStatement pst = null;
        ResultSet result = null;

        String sql = "SELECT IDPOKEMON FROM POKEMON WHERE NAME=" + "'" + pokeName + "' ";

        try {

            pst = con.prepareStatement(sql);
            result = pst.executeQuery();

            if (result.next()) {

                idpokemon = result.getInt("IDPOKEMON");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, ex);

                }
            }
        }

        return idpokemon;

    }

    public void cmbPoke(Connection con, JComboBox cboxUser, String name, String from) {
        PreparedStatement pst = null;
        ResultSet result = null;
        String sql = "SELECT " + name + " FROM " + from;

        try {

            pst = con.prepareStatement(sql);
            result = pst.executeQuery();

            cboxUser.addItem("Select An Option");

            while (result.next()) {

                cboxUser.addItem(result.getString(name));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void list(Connection con, JList list, String name) {
        DefaultListModel model;
        int id = 0;

        model = new DefaultListModel();
        String sql = name;

        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                id = 1;
                String n = rs.getString("NAME");
                model.addElement(n);

            }

            list.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR LIST ");
        }

    }

    public int searchLvl(Connection con, int id, String s) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Search for the level
            st = con.prepareStatement(s);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                id = rs.getInt("LEVEL");

            } else {
                id = 0;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error LEVEL");
        }

        return id;

    }

    public String addObject(Connection con, String d, String h) {
        PreparedStatement pst = null;
        ResultSet rs;

        String search = "SELECT * FROM " + d + " WHERE NAME = '" + h + "'";

        try {
            pst = con.prepareStatement(search);
            rs = pst.executeQuery();
            if (rs.next()) {
                message = "That name already exists";
                return message;
            }

        } catch (SQLException e) {
            message = "ERROR SAVE \n " + e.getMessage();
        }

        String sql = "INSERT INTO " + d + " (NAME) VALUES( '" + h + "')";
        try {

            pst = con.prepareStatement(sql);
            message = "Insert ";
            pst.execute();
            pst.close();
            con.commit();

        } catch (SQLException e) {
            message = "ERROR SAVE \n " + e.getMessage();
        }

        return message;
    }

    public void deleteObject(Connection con, String sql) {
        PreparedStatement st = null;

        try {

            st = con.prepareStatement(sql);
            st.execute();
            con.commit();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR DELETE");
        }

    }

}
