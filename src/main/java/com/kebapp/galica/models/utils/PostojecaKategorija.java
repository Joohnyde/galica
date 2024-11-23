/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.models.utils;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author denijal
 */
public class PostojecaKategorija implements Serializable{
        private UUID postojeceKategorija;
        private Integer min;
        private Integer max;
        private Boolean copyMinMax = true;

        public PostojecaKategorija() {
        }
        
        public PostojecaKategorija(UUID postojeceKategorija, Integer min, Integer max, Boolean copy){
            this.postojeceKategorija = postojeceKategorija;
            this.min = min;
            this.max = max;
            this.copyMinMax = copy;
        }

        public UUID getPostojeceKategorija() {
            return postojeceKategorija;
        }

        public void setPostojeceKategorija(UUID postojeceKategorija) {
            this.postojeceKategorija = postojeceKategorija;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Boolean getCopyMinMax() {
            return copyMinMax;
        }

        public void setCopyMinMax(Boolean copyMinMax) {
            this.copyMinMax = copyMinMax;
        }
        
        
    }
