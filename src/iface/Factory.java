/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iface;

/**
 *
 * 
 */
public interface Factory {

    public Executor getExecutor();

    public FileRW getFileRW();
}
