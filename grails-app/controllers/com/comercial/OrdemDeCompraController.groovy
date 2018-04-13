package com.comercial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrdemDeCompraController {

    OrdemDeCompraService ordemDeCompraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ordemDeCompraService.list(params), model:[ordemDeCompraCount: ordemDeCompraService.count()]
    }

    def show(Long id) {
        respond ordemDeCompraService.get(id)
    }

    def create() {
        respond new OrdemDeCompra(params)
    }

    def save(OrdemDeCompra ordemDeCompra) {
        if (ordemDeCompra == null) {
            notFound()
            return
        }

        try {
            ordemDeCompraService.save(ordemDeCompra)
        } catch (ValidationException e) {
            respond ordemDeCompra.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ordemDeCompra.label', default: 'OrdemDeCompra'), ordemDeCompra.id])
                redirect ordemDeCompra
            }
            '*' { respond ordemDeCompra, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ordemDeCompraService.get(id)
    }

    def update(OrdemDeCompra ordemDeCompra) {
        if (ordemDeCompra == null) {
            notFound()
            return
        }

        try {
            ordemDeCompraService.save(ordemDeCompra)
        } catch (ValidationException e) {
            respond ordemDeCompra.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ordemDeCompra.label', default: 'OrdemDeCompra'), ordemDeCompra.id])
                redirect ordemDeCompra
            }
            '*'{ respond ordemDeCompra, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ordemDeCompraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ordemDeCompra.label', default: 'OrdemDeCompra'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ordemDeCompra.label', default: 'OrdemDeCompra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
