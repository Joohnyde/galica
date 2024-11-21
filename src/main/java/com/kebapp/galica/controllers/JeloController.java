/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.controllers;

import com.kebapp.galica.interfaces.interfaces.JeloInterface;
import com.kebapp.galica.models.request.CreateJeloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author denijal
 */
@RestController
@RequestMapping("jelo")
public class JeloController {
    
    @Autowired
    private JeloInterface jeloInterface;
    
    /*
        Ова метода се зове приликом креирања јела. Приступ медоти је заштићен и 
    дозвољен је само кебабџијама. Поред креирања јела у бази, метода предвиђа 
    и следеће сценарије:
        * креирање нове категорије од нуле
        * придодавање већ постојеће категорије
        * креирање нове категорије на освову већ постојеће
        * креирање новог прилога приликом креирања категорије
    
        Метода захтева објекат типа CreateJeloModel који се доставља као његова
    ЈSON репрезентација унутар тела HTTP захтева. Тај објекат садржи:
        * String ime;
            - Име јела које се креира
        * String? opis; 
            - Опционални опис јела које се креира
        * Byte[]? slika; 
            - Опционални низ бајтова који представља слику јела
        * Double baseCena; 
            - Реална, позитивна, цена јела
        * Double? baseTime;
            - Опционално време припреме јела (у минутима). Уколико није доста-
            вљено, подразумева се 5 минута.
        * PostojecaKategorija[]? postojeceKategorije;
            - Опционални објекат на основу ког се постојеће категорије придодају
            јелу.
        * CreateKategorijaModel[]? noveKategorije;
            - Опционални објекти на основу којих се креирају нове категорије, 
            које се потом придодају јелу.
       
        Објекат типа PostojecaKategorija има следећа поља:
        * UUID postojeceKategorija
            - UUID постојећег објекта Kategorijajelo.
        * Boolean copyMinMax
            - Уколико се категорија копира од неког постојећег јела на којем је 
            можда дефинисан минимум и максимум прилога који се могу изабрати из 
            категорије, да ли се копира и опсег? Овим атрибутом се регулише тај
            избор.
        * Integer min
            - Уколико се не копира опсег, овај позитиван цели број одговара 
            минимуму прилога који се морају изабрати из категорије. Уколико не
            постоји, ово поље је null.   
        * Integer max
            - Исто објашњење као и за претходни атрибут
    
        За креирање категорије је креирана посебне класе CreateKategorijaModel и
    PrilogKategorija (различито од com.kebapp.galica.entities.Prilogkategorija).
    Исти објекат се користи за креирање категорије ван контекста креирања јела.
    Објекат типа CreateKategorijaModel садржи:
        * String ime
            - Име категорије која се креира
        * Integer? min
            - Опционалан позитиван цео број који представља минимум прилога који
            се морају изабрати из категорије. Подразумевано је 0
        * Integer? max
            - Опционалан позитиван цео број који представља максималан број 
            прилога који се морају изабрати из категорије. Подразумевано је
            неограничено
        * PrilogKategorija[] prilozi
            - Низ објеката на основу којих се додају прилози у категорију, одно-
            сно креирају.
         
        Објекат типа PrilogKategorija преставља или постојећи прилог којег треба
    придодати категорији која се креира или потпуно нови прилог којег претходно
    треба креирати. Он садржи:
        * UUID? postojeciPrilog
            - Уколико прилог већ постоји, његов UUID се уноси овде. У супротном
            поље остаје празно
        * CreatePrilogModel? noviPrilog
            - Уколико прилог не постоји, он се креира на основу овог објекта. У
            супротном је поље null
        * Double? extraCena
            - Реалан, позитиван број који представља износ доплате која се дода-
            је уколико је прилог изабран. Уколико се број не достави, подразуме-
            ва се да је прилог бесплатан
        * Boolean podrazumevano
            - Опционална булова вредност која означава да ли је прилог подразу-
            мевано укључен у јело или није. Уколико се не достави, вредност је 
            false
    
        Креирање новог прилога се врши на основу CreatePrilogModel објекта. У 
    њему се налазе подаци потребни бази приликом чувања:
        * String ime;
            - Име прилога које се креира
        * String? opis; 
            - Опционални опис прилога које се креира
        * Byte[]? slika; 
            - Опционални низ бајтова који представља слику прилога
    
        Метода током обраде захтева може наићи на неколико изузетака који су
    позиваоцу назначени посебним одговорним кодовима:
        200 - Извршење је протекло регуларно. У телу одговора се налази UUID
              новокреираног јела
        403 - Грешка коју враћа Spring да назначи да се у ауторизационом загла-
              вљу не налази токен наведен у конфигурацији.
        422 - Грешка која се враћа као одговор у случају да је наведен непосто-
              јећи UUID у било ком тренутку.
        400 - Грешка која се враћа кад се примети семантичка неправилност, нпр.
              неке од реалних вредности су негативне и сл.

        Линк ка таску: https://tree.taiga.io/project/joohnyde-galica/us/6
    */
    @PostMapping("create")
    public ResponseEntity<Void> createJelo(@RequestBody CreateJeloModel body){
        return null;
    }
    
}
