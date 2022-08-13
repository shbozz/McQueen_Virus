package dev.shbozz

import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JProgressBar
import java.lang.InterruptedException
import javax.swing.JOptionPane
import javax.swing.ImageIcon
import java.util.Objects
import kotlin.Throws
import javax.swing.UnsupportedLookAndFeelException
import java.lang.ClassNotFoundException
import java.lang.InstantiationException
import java.lang.IllegalAccessException
import kotlin.jvm.JvmStatic
import javax.swing.UIManager

class Main {
    //a swing gui dialog
    //a swing panel
    var panel = JPanel()

    //another swing panel
    var panel2 = JPanel()

    //a swing label
    var label = JLabel("Mcqueen virus, infecting your computer...")

    //a swing frame
    var frame = JFrame("mcqueen.exe")

    //another swing frame
    var frame2 = JFrame("mcqueen virus")

    //a swing text field
    var textArea = JTextArea(10, 20)

    //swing progress bar
    var progressBar = JProgressBar(1, 100)
    fun setUpGUI() {
        //set up the frame
        frame.isResizable = false
        frame.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        frame.setSize(300, 300)
        frame.isVisible = true
        frame.contentPane = panel
        //set up the text field
        textArea.text = "Your notebook"
        //add the label to the panel
        panel.add(label)
        //add the text field to the panel
        panel.add(textArea)
        //add the progress bar to the panel
        frame.add(progressBar)
    }

    fun startVirus() {
        //set up the progress bar
        for (i in 0..100) {
            progressBar.value = i
            try {
                Thread.sleep(50)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        //show the message
        JOptionPane.showMessageDialog(
            null,
            "mcqueen.exe has infected your computer!",
            "mcqueen.exe",
            JOptionPane.INFORMATION_MESSAGE
        )
        //set up
        frame.isVisible = false
        frame.dispose()
        frame2.isUndecorated = true
        setupVirusGUI()
        frame2.isVisible = true
    }

    fun setupVirusGUI() {
        //set up the frame
        frame2.isResizable = false
        frame2.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        frame2.isVisible = true
        frame2.contentPane = panel2
        //add the label to the panel
        val icon = ImageIcon(Objects.requireNonNull(Main::class.java.getResource("mcqueenos.png")))
        panel2.add(JLabel(icon))
        frame2.contentPane = panel2
        frame2.extendedState = JFrame.MAXIMIZED_BOTH
    }

    companion object {
        @Throws(
            UnsupportedLookAndFeelException::class,
            ClassNotFoundException::class,
            InstantiationException::class,
            IllegalAccessException::class
        )
        @JvmStatic
        fun main(args: Array<String>) {
            //set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            JOptionPane.showMessageDialog(
                null,
                "mcqueen.exe is starting...",
                "Mcqueen.exe",
                JOptionPane.INFORMATION_MESSAGE
            )
            //set up the gui
            val main = Main()
            main.setUpGUI()
            //start the virus
            main.startVirus()
        }
    }
}