package com.comercial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrdemDeCompraServiceSpec extends Specification {

    OrdemDeCompraService ordemDeCompraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OrdemDeCompra(...).save(flush: true, failOnError: true)
        //new OrdemDeCompra(...).save(flush: true, failOnError: true)
        //OrdemDeCompra ordemDeCompra = new OrdemDeCompra(...).save(flush: true, failOnError: true)
        //new OrdemDeCompra(...).save(flush: true, failOnError: true)
        //new OrdemDeCompra(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ordemDeCompra.id
    }

    void "test get"() {
        setupData()

        expect:
        ordemDeCompraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OrdemDeCompra> ordemDeCompraList = ordemDeCompraService.list(max: 2, offset: 2)

        then:
        ordemDeCompraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ordemDeCompraService.count() == 5
    }

    void "test delete"() {
        Long ordemDeCompraId = setupData()

        expect:
        ordemDeCompraService.count() == 5

        when:
        ordemDeCompraService.delete(ordemDeCompraId)
        sessionFactory.currentSession.flush()

        then:
        ordemDeCompraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra()
        ordemDeCompraService.save(ordemDeCompra)

        then:
        ordemDeCompra.id != null
    }
}
