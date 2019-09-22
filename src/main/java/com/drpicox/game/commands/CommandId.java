package com.drpicox.game.commands;

import java.io.Serializable;

public class CommandId implements Serializable {
    private String player;
    private Long entity;
    private String type;

    CommandId() {}
}
