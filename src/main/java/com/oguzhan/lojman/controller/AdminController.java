package com.oguzhan.lojman.controller;

import com.oguzhan.lojman.model.LojmanBlok;
import com.oguzhan.lojman.model.LojmanDairesi;
import com.oguzhan.lojman.service.BlokService;
import com.oguzhan.lojman.service.DaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

    @Autowired
    private BlokService blokService;

    @Autowired
    private DaireService daireService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String admin(ModelMap model) {

        return "admin";
    }

    @RequestMapping(value = "/daireler", method = RequestMethod.GET)
    public String daireler(ModelMap model) {

        List<LojmanDairesi> daireler = daireService.loadDaireler();
        model.addAttribute("daireler", daireler);

        return "daireler";
    }

    @RequestMapping(value = "/bloklar", method = RequestMethod.GET)
    public String bloklar(ModelMap model) {

        List<LojmanBlok> bloklar = blokService.loadBloklar();
        model.addAttribute("bloklar", bloklar);

        return "bloklar";
    }

    @RequestMapping(value = "/daire/ekle", method = RequestMethod.GET)
    public String adminHome(ModelMap model) {

        LojmanDairesi daire = new LojmanDairesi();
        model.addAttribute("daire", daire);
        model.addAttribute("bloklar", blokService.loadBloklar());

        return "daireForm";
    }

    @RequestMapping(value = "/blok/ekle", method = RequestMethod.GET)
    public String daireForm(ModelMap model) {

        LojmanBlok blok = new LojmanBlok();
        model.addAttribute("blok", blok);

        return "blokForm";
    }

    @RequestMapping(value = "/daire/{daireId}/guncelle", method = RequestMethod.GET)
    public String daireFormGuncelle(@PathVariable("daireId") Long id, ModelMap model) {

        LojmanDairesi daire = daireService.loadDaireById(id);
        model.addAttribute("daire", daire);
        model.addAttribute("bloklar", blokService.loadBloklar());

        return "daireForm";
    }

    @RequestMapping(value = "/blok/{blokId}/guncelle", method = RequestMethod.GET)
    public String blokFormGuncelle(@PathVariable("blokId") Long id, ModelMap model) {

        LojmanBlok blok = blokService.loadBlokById(id);
        model.addAttribute("blok", blok);

        return "blokForm";
    }
///////////////dasdas7/////////////////
    @RequestMapping(value = "/daire", method = RequestMethod.POST)
    public String daireEkleVeyaGuncelle(@ModelAttribute("daire") LojmanDairesi daire) {

        daireService.saveOrUpdateDaire(daire);

        return "redirect:/admin/daireler";
    }

    @RequestMapping(value = "/blok", method = RequestMethod.POST)
    public String blokForm(@ModelAttribute("blok") LojmanBlok blok) {

        blokService.saveOrUpdateBlok(blok);

        return "redirect:/admin/bloklar";
    }

    @RequestMapping(value = "/daire/{daireId}/sil", method = RequestMethod.GET)
    public String daireSil(@PathVariable("daireId") Long id, ModelMap model) {

        //nesne

        LojmanDairesi daire = daireService.loadDaireById(id);
        daireService.removeDaire(daire);

        return "redirect:/admin/daireler";
    }

    @RequestMapping(value = "/blok/{blokId}/sil", method = RequestMethod.GET)
    public String blokSil(@PathVariable("blokId") Long id, ModelMap model) {

        LojmanBlok blok = blokService.loadBlokById(id);
        blokService.removeBlok(blok);

        return "redirect:/admin/bloklar";
    }

    @RequestMapping(value = "/daire/{daireId}/kirala", method = RequestMethod.GET)
    public String daireKirala(@PathVariable("daireId") Long id, ModelMap model) {

        LojmanDairesi daire = daireService.loadDaireById(id);
        model.addAttribute("daire", daire);
        model.addAttribute("bloklar", blokService.loadBloklar());

        return "daireKirala";
    }

}
