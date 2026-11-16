package br.com.contmatic.prova;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AuditoriaTest.class, EmpresaTest.class, EnderecoTest.class, TelefoneTest.class})
class TodosOsTestes {

}
