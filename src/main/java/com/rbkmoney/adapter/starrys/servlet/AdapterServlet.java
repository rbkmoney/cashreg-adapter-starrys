package com.rbkmoney.adapter.starrys.servlet;

import com.rbkmoney.adapter.starrys.handler.StarrysServerHandler;
import com.rbkmoney.cashreg.proto.provider.CashRegProviderSrv;
import com.rbkmoney.woody.thrift.impl.http.THServiceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/adapter/cashreg/starrys")
public class AdapterServlet extends GenericServlet {

    @Autowired
    private StarrysServerHandler handler;

    private Servlet servlet;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servlet = new THServiceBuilder().build(CashRegProviderSrv.Iface.class, handler);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        servlet.service(request, response);
    }

}

