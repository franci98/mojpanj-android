package si.kflabs.mojpanj.data.domain

import java.time.Month

enum class BeeTaskMonth(
    val title: String,
) {
    JANUARY("Januar"),
    FEBRUARY("Februar"),
    MARCH("Marec"),
    APRIL("April"),
    MAY("Maj"),
    JUNE("Junij"),
    JULY("Julij"),
    AUGUST("Avgust"),
    SEPTEMBER("September"),
    OCTOBER("Oktober"),
    NOVEMBER("November"),
    DECEMBER("December");

    val tasks: List<BeeTask>
        get() {
            return when(this) {
                JANUARY -> listOf(
                    BeeTask("Čiščenje snega", ""),
                    BeeTask("Skrb za mir na čebelnjaku", ""),
                    BeeTask("Priprava in ureditev čebelarskega pribora", ""),
                    BeeTask("Nabava novih čebeljih panjev, stanic", ""),
                    BeeTask("Izobraževanje", ""),
                    BeeTask("Urejanje čebelarskega inventarja", ""),
                    BeeTask("Žičenje satnikov", ""),
                    BeeTask("Pridobivanje propolisa", ""),
                    BeeTask("Urejanje nenaseljenih panjev", ""),
                    // itd.
                )
                FEBRUARY -> listOf(
                    BeeTask("Kontrola čebel pri čistilnem izletu", ""),
                    BeeTask("Pomoč čebeljim družinam, ki so ostale brez hrane", ""),
                    BeeTask("Čiščenje podničnih vložkov oz. podnic", ""),
                    BeeTask("Ureditev napajalnika", ""),
                    BeeTask("Čiščenje snega in skrb za mir na čebelnjaku", ""),
                    // itd.
                )
                MARCH -> listOf(
                    BeeTask("Temeljit pregled čebeljih družin", ""),
                    BeeTask("Preveriti zalogo hrane", ""),
                    BeeTask("Sajenje medovitih rastlin", ""),
                    BeeTask("Priprava satnic", ""),
                    // itd.
                )
                APRIL -> listOf(
                    BeeTask("Kontrolni pregled čebeljih družin", ""),
                    BeeTask("Preveriti zalego", ""),
                    BeeTask("Preveriti zalogo hrane", ""),
                    BeeTask("Gradnja čim več satnic", ""),
                    BeeTask("Zbiranje cvetnega prahu", ""),
                    BeeTask("Izenačevanje družin", ""),
                    // itd.
                )
                MAY -> listOf(
                    BeeTask("Kontrolni pregled čebeljih družin", ""),
                    BeeTask("Preprečevanje rojenja", ""),
                    BeeTask("Vstavljanje gradilnih satov", ""),
                    BeeTask("Omogočanje prostora v medišču", ""),
                    BeeTask("Prevoz čebel na pašo", ""),
                    // itd.
                )
                JUNE -> listOf(
                    BeeTask("Kontrolni pregled čebeljih družin", "."),
                    BeeTask("Vzreja matic", "."),
                    BeeTask("Vzreja rezervnih družin", "."),
                    BeeTask("Izrezovanje trotovine", "."),
                    BeeTask("Točenje medu", "."),
                    // itd.
                )
                JULY -> listOf(
                    BeeTask("Pregled čebel", ""),
                    BeeTask("Točenje medu", ""),
                    BeeTask("Zamenjava matic", ""),
                    BeeTask("Izdelava ometencev", ""),
                    // itd.
                )
                AUGUST -> listOf(
                    BeeTask("Hranjenje čebel za zimo", ""),
                    BeeTask("Zagotovitev pomlajevalne paše", ""),
                    BeeTask("Preprečevanje ropa", ""),
                    // itd.
                )
                SEPTEMBER -> listOf(
                    BeeTask("Preprečevanje ropa", ""),
                    BeeTask("Odstranitev neprimernega medu", ""),
                    BeeTask("Dopolnitev zimske zaloge hrane", ""),
                    BeeTask("Kontrola družin, ki smo ji zamenjali matico", ""),
                    // itd.
                )
                OCTOBER -> listOf(
                    BeeTask("", ""),
                    // itd.
                )
                NOVEMBER -> listOf(
                    BeeTask("", ""),
                    // itd.
                )
                DECEMBER -> listOf(
                    BeeTask("", ""),
                    // itd.
                )
            }
        }
}