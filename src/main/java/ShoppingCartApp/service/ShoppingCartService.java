package ShoppingCartApp.service;

import ShoppingCartApp.dao.ShoppingCartDAO;
import ShoppingCartApp.dao.ShoppingCartDAOImpl;
import ShoppingCartApp.model.ShoppingItems;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartService {

    ShoppingCartDAO shoppingCartDAOImpl = (ShoppingCartDAO) new ShoppingCartDAOImpl();

    public boolean addItem(ArrayList<Integer> itemsChosen) {

        HashMap<Integer, ShoppingItems> itemMap = shoppingCartDAOImpl.getHash();
        boolean isAdded = false;
        for (int i = 0; i < itemsChosen.size(); i++) {
            if(itemMap.containsKey(itemsChosen.get(i))) {
                shoppingCartDAOImpl.addItem(itemsChosen.get(i));
                isAdded = true;
            }
        }

        return isAdded;
    }

    public boolean deleteItem(int deleteId) {

        //deleting item from cart by id, return true if it was deleted and displaying relevant information to the user
        boolean isDeleted = shoppingCartDAOImpl.deleteItem(deleteId);
        return isDeleted;
    }
    public List<ShoppingItems> getItemList() {
        return shoppingCartDAOImpl.getAllItems();
    }

    public ArrayList<Integer> getCartList() {
        return shoppingCartDAOImpl.cartList();
    }

    public HashMap<Integer,ShoppingItems> getHash() {
        return shoppingCartDAOImpl.getHash();
    }

    public void populateItems(){
        //populating data for available items
        shoppingCartDAOImpl.populateMap();
    }
}
