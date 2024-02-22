package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

//дверь - за ней может либо скрываться приз, либо нет
public class Door {
    private boolean hasPrize;
}
