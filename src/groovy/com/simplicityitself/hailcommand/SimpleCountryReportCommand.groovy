package com.simplicityitself.hailcommand


class SimpleCountryReportCommand {

  CountrySearchService countrySearchService

  String countryName = ""

  def call() {
    def countries = countrySearchService.searchCountries(countryName)

    def countriesReworked = countries.collect {
      [name:it.name, currency:"CODE:${it.currency}", tld:it.tld]
    }

    return [
        "search":countryName,
        "date":new Date(),
        "countries":countriesReworked
    ]
  }

  static constraints = {
    countryName(nullable:false)
  }
}
