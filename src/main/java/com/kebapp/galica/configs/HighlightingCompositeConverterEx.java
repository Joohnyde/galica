/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.configs;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 *
 * @author denijal
 */

// Класа у којој дефинишем којом бојом ће се исписати који тип логова.
public class HighlightingCompositeConverterEx extends ForegroundCompositeConverterBase<ILoggingEvent> {

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        Level level = event.getLevel();
        return switch (level.toInt()) {
            case Level.ERROR_INT -> ANSIConstants.RED_FG;   // Грешке - црвено
            case Level.WARN_INT -> ANSIConstants.YELLOW_FG; // Упозорења - жута
            case Level.INFO_INT -> ANSIConstants.GREEN_FG;   // Општи - зелени
            default -> ANSIConstants.DEFAULT_FG;
        };
    }

}