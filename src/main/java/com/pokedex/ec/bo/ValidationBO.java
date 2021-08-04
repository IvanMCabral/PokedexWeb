/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pokedex.ec.bo;

/**
 *
 * @author 
 */
public class ValidationBO {

    public boolean Validation(String text) {
               
        int num;
        try {
            num = Integer.parseInt(text);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    
    
}
