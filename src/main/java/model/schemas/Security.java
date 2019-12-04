/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joses
 */

@Entity
@Table(name = "security_question")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsecurity_question")
    private int Id;
    @Column(name = "question")
    private String question;
    
    public Security(){}
    
    public Security(String question){
        this.question = question;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public String getQuestion(){
        return this.question;
    }
}
