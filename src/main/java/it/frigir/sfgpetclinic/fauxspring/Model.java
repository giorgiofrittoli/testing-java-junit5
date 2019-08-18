package it.frigir.sfgpetclinic.fauxspring;

public interface Model {

    void addAttribute(String key, Object o);

    void addAttribute(Object o);

    Object getAttribute(String key);
}
