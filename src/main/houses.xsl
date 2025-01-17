<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>House Catalog</h2>
                <table border="1">
                    <tr>
                        <th>Address</th>
                        <th>Builder</th>
                        <th>Price</th>
                        <th>Construction Date</th>
                    </tr>
                    <xsl:for-each select="catalog/house">
                        <tr>
                            <td><xsl:value-of select="address"/></td>
                            <td><xsl:value-of select="builder"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="construction_date"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
