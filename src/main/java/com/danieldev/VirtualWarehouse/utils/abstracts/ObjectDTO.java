package com.danieldev.VirtualWarehouse.utils.abstracts;

import com.danieldev.VirtualWarehouse.utils.fields.Action;
import com.danieldev.VirtualWarehouse.utils.fields.Method;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class ObjectDTO {
    protected Long id;
    protected List<Action> actions = new ArrayList<>();

    protected void addAction(String actionName, String uri, Method method){
        Action action = new Action(actionName, uri, method);
        actions.add(action);
    }

    protected void addAction(String actionName, String uri, Method method, List<String> params){
        Action action = new Action(actionName, uri, method);
        action.setParams(params);
        actions.add(action);

    }
}
