<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.it-academy.by">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <style>
                </style>
                <title>Point List</title>
            </head>
            <body>
                <h2 align="center">Point List</h2>
                <table border="1" align="center">
                    <tr bgcolor="#9acd32">
                        <th colspan="2">Points</th>
                    </tr>
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                    </tr>
                    <xsl:for-each select="xs:pointsList/xs:point">
                        <tr>
                            <td>
                                <xsl:value-of select="xs:x"/>
                                <span>&#160;</span>
                                <xsl:value-of select="@unit"/>
                            </td>
                            <td>
                                <xsl:value-of select="xs:y"/>
                                <span>&#160;</span>
                                <xsl:value-of select="@unit"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>