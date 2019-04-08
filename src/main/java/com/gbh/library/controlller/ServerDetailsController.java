package com.gbh.library.controlller;

import com.gbh.library.utility.Constant;
import com.gbh.library.utility.OutputResponse;
import com.gbh.library.utility.ServerDetail;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sinoa
 */
@RestController
@RequestMapping("/serverDetail")
public class ServerDetailsController {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/serverInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OutputResponse getServerDetails() {
        ServerDetail serverDetail = new ServerDetail();
        try {

            serverDetail.setPort(environment.getProperty("local.server.port"));

            serverDetail.setLocalHostAddress(InetAddress.getLocalHost().getHostAddress());
            serverDetail.setLocalHostName(InetAddress.getLocalHost().getHostName());

            serverDetail.setRemoteHostAddress(InetAddress.getLoopbackAddress().getHostAddress());
            serverDetail.setRemoteHostName(InetAddress.getLoopbackAddress().getHostName());
            serverDetail.setMessage(Constant.SUCCESS_MSG);
            serverDetail.setCode(Constant.SUCCESS_CODE);
        } catch (UnknownHostException ex) {
            serverDetail.setMessage(Constant.ERROR_MSG + " : " + ex.getMessage());
            serverDetail.setCode(Constant.ERROR_CODE);
        }
        return serverDetail;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map pingServer() {
        Map map = new HashMap();
        map.put("message", "Server is running !!!");
        return map;
    }

}
