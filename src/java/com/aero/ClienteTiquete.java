/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aero;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * @author yepesk8r
 */
public class ClienteTiquete {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WS_REST_ValorTiquete/webresources";

    public ClienteTiquete() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("valortiquete");
    }

    public String compramillas(String TipoSocio, String monto) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (TipoSocio != null) {
            resource = resource.queryParam("TipoSocio", TipoSocio);
        }
        if (monto != null) {
            resource = resource.queryParam("monto", monto);
        }
        resource = resource.path("comprademillas");
        return resource.toString();
    }

    public String vehiculo(String monto) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (monto != null) {
            resource = resource.queryParam("monto", monto);
        }
        resource = resource.path("calculodemillas");
        return resource.toString();
    }

    public String valortiquete(String valor, String sillas) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (valor != null) {
            resource = resource.queryParam("valor", valor);
        }
        if (sillas != null) {
            resource = resource.queryParam("sillas", sillas);
        }
        return resource.toString();
    }

    public void close() {
        client.close();
    }
    
}
