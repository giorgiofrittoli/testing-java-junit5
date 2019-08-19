package it.frigir.sfgpetclinic.fauxspring;

import it.frigir.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class ModelImpl implements Model {

    HashMap<String, Object> hashMap = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        hashMap.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
    }

    @Override
    public Object getAttribute(String key) {
        return hashMap.get(key);
    }
}
