package com.danieldev.VirtualWarehouse.utils.fields;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Action {
    String name;
    String uri = "http://localhost:8080/api/v1";
    @Enumerated(EnumType.STRING)
    Method method;

    List<String> params = new ArrayList<>();
    public Action(String name, String uri, Method method) {
        this.name = name;
        this.uri += uri;
        this.method = method;
    }
}
