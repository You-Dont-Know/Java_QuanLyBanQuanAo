/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;

/**
 *
 * @author hieun
 */
public interface Interface_IQueryDatabase<T> {

    public List<T> getALL();

    public void Add(T item);

    public void Update(T item);

    public int Delete(T item);

}
