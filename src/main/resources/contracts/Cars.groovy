package com.example.mvntesting11


org.springframework.cloud.contract.spec.Contract.make {
    request { // (1)
        method 'GET' // (2)
        url '/cars/test' // (3)
        headers { // (5)
            contentType('application/json')
        }
    }
    response { // (6)
        status OK() // (7)
        body([ // (8)
               id  :$(regex(number())),
               name: $(regex('^[a-zA-Z\'-]+$')),
        ])
        headers { // (9)
            contentType('application/json')
        }
    }
}