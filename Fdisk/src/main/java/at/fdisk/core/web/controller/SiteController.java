package at.fdisk.core.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.service.FdiskManagementService;

@Controller
@RequestMapping("/")
public class SiteController {

    private static final Logger LOG = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private FdiskManagementService fdiskManagementService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentAusbildungen() {
        LOG.debug("Fdisk menu directly to ResponseBody");
        return ausbildungPrint(fdiskManagementService.getAllAusbildungen());
    }

    private String ausbildungPrint(List<Ausbildung> ausbildungen) {
        StringBuffer sb = new StringBuffer();
        String delim = "";
        for (int i = 0; i < ausbildungen.size(); i++) {
            sb.append(delim).append(ausbildungen.get(i).getBezeichnung());
            delim = ",";
        }

        return sb.toString();
    }

}