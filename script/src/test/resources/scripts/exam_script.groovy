enable 'xml'

transform '//Item' by { item ->
    if (item.bankKey.startsWith('10')) {
        item.bankKey = item.bankKey.substring(2)
    }
}

transform '//Response' by { response ->
    def text = response.text

    if (text.contains('choiceInteraction_1') && text.contains('choiceInteraction_2')) {
        response.text = text
                .replaceAll(~/choiceInteraction_(\d).RESPONSE/, 'EBSR$1')
                .replaceAll(~/choiceInteraction_\d-choice-(\w)/, '$1')

    } else if (text.contains('choiceInteraction_1')) {
        def matches = text =~ /choiceInteraction_1-choice-(\w)/
        if (matches.count > 0) {
            response.text = matches.collect { it[1] }.join(',')
        }

    } else if (text.contains('matchInteraction')) {
        response.text = text
                .replaceAll(~/matchInteraction_\d.RESPONSE/, 'RESPONSE')
                .replaceAll(~/matchInteraction_\d-(\d)\W*matchInteraction_\d-(\w)/, '$1 $2')

    } else if (text.contains('hotTextInteraction_')) {
        response.text = text
                .replaceAll(~/hotTextInteraction_(\d).RESPONSE/, '$1')
                .replaceAll(~/hotTextInteraction_\d-hottext-(\d)/, '$1')

    } else if ( text.contains('equationInteraction_') ||
                text.contains('tableInteraction_') ||
                text.contains('gridInteraction_') ||
                text.contains('textEntryInteraction_')) {
        response.text = text
                .replaceAll(~/(?s).+<value>(.+)<\/value>.+/, '$1')
                .unescapeHtmlTags()
    }
}

outputXml
