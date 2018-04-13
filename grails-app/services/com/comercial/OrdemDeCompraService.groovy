package com.comercial

import grails.gorm.services.Service

@Service(OrdemDeCompra)
interface OrdemDeCompraService {

    OrdemDeCompra get(Serializable id)

    List<OrdemDeCompra> list(Map args)

    Long count()

    void delete(Serializable id)

    OrdemDeCompra save(OrdemDeCompra ordemDeCompra)

}