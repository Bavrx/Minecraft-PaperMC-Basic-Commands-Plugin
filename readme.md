# FirstPlugin – Minecraft Paper Plugin

Ein modulares Minecraft-Server-Plugin von **Bavrx** (MB MC Studios) auf Basis der **Paper API** und **Adventure MiniMessage**. Das Projekt bündelt nützliche Admin- und Spieler-Befehle, spezielle Welt-Events sowie eine leichtgewichtige Befehlsarchitektur (`PlayerCommand`), mit der neue Features mit minimalem Code-Aufwand ergänzt werden können.

## Überblick & Features

* **Spieler- & Admin-Befehle:** Direkte Steuerung von Flugmodus, Flug- und Laufgeschwindigkeit, Heilung, Unverwundbarkeit (Godmode), Unsichtbarkeit (Vanish) sowie Spieler-Freeze per Barrier-Käfig.
* **Event-Mechaniken:** Benutzerdefinierte Join-Nachrichten sowie aktive und optionale Welt-Interaktionen (z. B. explodierende Grasblöcke und Abbau-Schutz).
* **Modulare Architektur:** Eigene abstrakte Basisklasse `PlayerCommand` auf Basis von Papers Brigadier `BasicCommand` inklusive Tab-Completion-Unterstützung.
* **Moderne Textformatierung:** Durchgängige Nutzung von Kyori Adventure `MiniMessage` für farbige und formatierte Chat-Ausgaben.

## Technische Eckdaten

| Eigenschaft | Wert |
| :--- | :--- |
| **Plugin-Name** | `first-plugin` |
| **Autor / Studio** | Bavrx (MB MC Studios) |
| **Hauptklasse** | `dev.Bavrx.firstPlugin.FirstPlugin` |
| **Server-API** | Paper API (`api-version: '26.2'`, Brigadier `BasicCommand`, Adventure API) |
| **Load-Phase** | `POSTWORLD` |

## Befehle (Commands)

Alle aktiven Spieler-Befehle erben von `PlayerCommand` und können direkt im Spiel ausgeführt werden. Neue Befehle lassen sich einfach als zusätzliche Zeile in dieser Tabelle ergänzen.

| Befehl | Parameter | Beschreibung | Klasse | Status |
| :--- | :--- | :--- | :--- | :--- |
| `/helpy` | Keine | Zeigt eine Übersicht aller verfügbaren Plugin-Befehle im Chat an | `Help.java` | Aktiv |
| `/heal` | `[player]` | Heilt dich selbst oder den angegebenen Spieler vollständig und füllt Hunger sowie Sättigung auf (inkl. Tab-Completion) | `Heal.java` | Aktiv |
| `/fly` | `[speed] [0-1 \| normal]` | Schaltet den Flugmodus an/aus oder setzt die Fluggeschwindigkeit zwischen `0` und `1` (`normal` = `0.1`) | `Fly.java` | Aktiv |
| `/walkspeed` | `<0-1 \| normal>` | Ändert deine Laufgeschwindigkeit zwischen `0` und `1` oder setzt sie mit `normal` auf `0.2` zurück | `WalkSpeed.java` | Aktiv |
| `/godmode` | `[player]` | Schaltet die Unverwundbarkeit für dich selbst oder einen Zielspieler an/aus | `Godmode.java` | Aktiv |
| `/vanish` | `[player]` | Schaltet die Unsichtbarkeit für dich selbst oder einen Zielspieler an/aus | `Vanish.java` | Aktiv |
| `/freez` | Keine | Umschließt die aktuelle Spielerposition mit einem Käfig aus Barrier-Blöcken | `Freez.java` | Aktiv |
| `/unfreez` | Keine | Entfernt den Barrier-Käfig rund um die aktuelle Spielerposition wieder | `UnFreez.java` | Aktiv |
| `/potion clear` | Keine | Entfernt aktive Trankeffekte vom Spieler | `PotionClear.java` | In Arbeit (WIP) |

&lt;!-- Vorlage für neue Befehle in der Tabelle:
| `/befehl` | `&lt;parameter&gt;` | Kurze Beschreibung der Funktion | `KlassenName.java` | Aktiv |
--&gt;

## Event-Listener & Module

Hier sind alle Event-Listener und Spezial-Module aufgelistet. Optionale Module können in `FirstPlugin.java` jederzeit ein- oder auskommentiert werden.

| Modul / Klasse | Paket | Event | Beschreibung | Status |
| :--- | :--- | :--- | :--- | :--- |
| `ConnectionListener` | `dev.Bavrx.firstPlugin.listeners` | `PlayerJoinEvent` | Sendet beim Betreten des Servers die rote Willkommensnachricht `"Wilkommen in MB MC Studios!"` | Aktiv |
| `GrassBomb` | `dev.Bavrx.firstPlugin.Layer0` | `BlockBreakEvent` | Ersetzt abgebaute Grasblöcke (`GRASS_BLOCK`) durch gezündetes TNT mit kurzer Zündschnur (10 Ticks) | Aktiv |
| `WorldProtector` | `dev.Bavrx.firstPlugin.Layer0` | `BlockBreakEvent` | Verhindert das Abbauen von Blöcken, startet einen 5-Sekunden-Countdown im Chat und kickt den Spieler | Deaktiviert (auskommentiert) |
| `Tester` | `dev.Bavrx.firstPlugin` | `BlockBreakEvent` | Test-Variante des Block-Abbau-Schutzes mit Countdown und Kick | Deaktiviert |

&lt;!-- Vorlage für neue Listener in der Tabelle:
| `NeuerListener` | `dev.Bavrx.firstPlugin.listeners` | `EventName` | Beschreibung des Verhaltens | Aktiv |
--&gt;

## Geplante Features & Work in Progress

* **Trankeffekte zurücksetzen (`PotionClear.java`):** Implementierung der Logik zum Löschen aller aktiven Potion-Effekte eines Spielers über `/potion clear`.
* **Custom Items (`EnderparlStick.java`):** Vorbereitung für ein eigenes Item auf Basis einer Lohenrute (`Material.BLAZE_ROD`) im Paket `dev.Bavrx.firstPlugin.items`.
* **Kleine Bugfixes für zukünftige Updates:**
  * In `Godmode.java` prüft der Zielspieler-Zweig aktuell `target.isInvisible()` statt `target.isInvulnerable()`.
  * In `Heal.java` wird die Bestätigungsnachricht `"You healed <Name>"` aktuell an `target` statt an `player` gesendet.

## Projektstruktur

```text
src/main/
├── java/dev/Bavrx/firstPlugin/
│   ├── FirstPlugin.java              # Hauptklasse (onEnable / onDisable, Registrierung)
│   ├── PlayerCommand.java            # Abstrakte Basisklasse für alle Spieler-Befehle
│   ├── Help.java                     # /helpy Befehlsübersicht
│   ├── Tester.java                   # Test-Listener
│   ├── execute/Player/               # Alle Spieler- und Admin-Commands
│   │   ├── Fly.java
│   │   ├── Freez.java
│   │   ├── Godmode.java
│   │   ├── Heal.java
│   │   ├── PotionClear.java
│   │   ├── Test.java
│   │   ├── UnFreez.java
│   │   ├── Vanish.java
│   │   └── WalkSpeed.java
│   ├── items/                        # Custom Items
│   │   └── EnderparlStick.java
│   ├── Layer0/                       # Welt-Mechaniken & Schutz-Listener
│   │   ├── GrassBomb.java
│   │   └── WorldProtector.java
│   └── listeners/                    # Server- & Verbindungs-Listener
│       └── ConnectionListener.java
└── resources/
    └── plugin.yml                    # Plugin-Metadaten
```

## Installation & Build

1. **Projekt kompilieren:** Baue die `.jar`-Datei über deine IDE (z. B. IntelliJ IDEA) oder dein Build-Tool (Gradle / Maven).
2. **Plugin ablegen:** Kopiere die erzeugte `.jar`-Datei in den `plugins/`-Ordner deines **Paper-Servers**.
3. **Server starten:** Starte den Server neu, damit `first-plugin` geladen wird. In der Konsole erscheint beim Start die Meldung `Plugin from Bavrx Enabled!`.

## Projekt erweitern (How to Extend)

Das Plugin ist so aufgebaut, dass du neue Befehle und Events in wenigen Schritten hinzufügen kannst.

### 1. Neuen Spieler-Befehl hinzufügen

Erstelle eine neue Klasse im Paket `dev.Bavrx.firstPlugin.execute.Player`, die von `PlayerCommand` erbt. Dadurch wird automatisch geprüft, ob der Befehl von einem echten Spieler ausgeführt wird:

```java
package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class MyNewCommand extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {
        player.sendMessage(MiniMessage.miniMessage().deserialize("<green>Befehl erfolgreich ausgeführt!"));
    }

    // Optional: Tab-Completion hinzufügen
    @Override
    public Collection<String> suggest(CommandSourceStack source, String[] args) {
        if (args.length == 0) {
            return List.of("option1", "option2");
        }
        return List.of();
    }
}
```

Registriere den Befehl anschließend in `FirstPlugin.java` innerhalb der Methode `onEnable()` und ergänze ihn optional in `Help.java`:

```java
registerCommand("mycommand", new MyNewCommand());
```

### 2. Neuen Event-Listener hinzufügen

Erstelle eine Klasse im Paket `dev.Bavrx.firstPlugin.listeners` (oder `Layer0`), die ` org.bukkit.event.Listener` implementiert:

```java
package dev.Bavrx.firstPlugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class MyNewListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // Eigene Event-Logik hier einfügen
    }
}
```

Registriere den Listener in `FirstPlugin.java` innerhalb von `onEnable()`:

```java
getServer().getPluginManager().registerEvents(new MyNewListener(), this);
```
