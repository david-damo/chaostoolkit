package com.wf.oecm.stcom.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OECMService {
    public List<String> getRainbow() {
        return Arrays.asList("Violet","Indigo","Blue"
        ,"Green","Yellow","Orange","Red");
    }
}
