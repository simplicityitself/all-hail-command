package com.simplicityitself.hailcommand

import spock.lang.Specification

class CountrySearchServiceSpec extends Specification {

  def "can query countries by name"() {
    given:
    def svc = new CountrySearchService()

    when:
    def countries = svc.searchCountries("Afghanistan")

    then:
    countries.size() == 1
    countries[0].name == "Afghanistan"
  }
  def "can query countries by partial name"() {
    given:
    def svc = new CountrySearchService()

    when:
    def countries = svc.searchCountries("Afghan")

    then:
    countries.size() == 1
    countries[0].name == "Afghanistan"
  }
  def "can query countries by partial lower case name"() {
    given:
    def svc = new CountrySearchService()

    when:
    def countries = svc.searchCountries("afghan")

    then:
    countries.size() == 1
    countries[0].name == "Afghanistan"
  }

}
